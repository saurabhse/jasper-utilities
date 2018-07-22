public class PieChartCustomizer implements JRChartCustomizer{
	
	static List<String> dataSetKeys = new ArrayList<String>();
	private static PieDataset createCustomizedDataset(PieDataset dataset, PiePlot piePlot) {
		DefaultPieDataset dataset1 = new DefaultPieDataset();
		for(int i=0;i< dataset.getItemCount().size();i++) {
			if(dataset.getValue(i).doubleValue()<0) {
				dataset1.setValue(dataset.getKey(i),Math.abs(((Double)dataset.getValue(i).doubleValue()));
				piePlot.setSectionPaint(dataset.getKey(i),Color.decode("#FFFFFF"));
				dataSetKeys.add(dataset.getKey(i).toString());
			}else {
				dataset1.setValue(dataset.getKey(i),dataset.getValue(i));
			}
			piePlot.setSectionOutlinePaint(dataset.getKey(i),Color.WHITE);
		}
		return dataset1;
	}
	
	public void customize(JfreeChart chart,JRChart jasperChart) {
		dataSetKeys.clear();
		PiePlot piePlot = (PiePlot) chart.getPlot();
		PieDataset dataset1 = createCustomizedDataset(piePlot.getDataset(),piePlot);
		StandardPieSectionLabelGenerator labelGen = new StandardPieSectionLabelGenerator("{2}") {
			@Override
			public String generateSectionLabel(PieDataset dataset, Comparable key) {
				String label = super.generateSectionLabel(dataset,key);
				if(label == null || Double.parseDouble(label.substring(0, label.length()-1)) < 5) {
					return null;
				}
				if(dataSetKeys.contains(key.toString())) {
					return "-"+label;
				}else {
					return label;
				}
			}
		};
		piePlot.setLabelGenerator(labelGen);
		piePlot.setShadowXOffset(0);
		piePlot.setShadowYOffset(0);
		piePlot.setShadowPaint(Color.WHITE);
		piePlot.setlabelBackgroundPaint(null);
		piePlot.setLabelOutlinePaint(null);
		piePlot.setLabelShaodwPaint(null);
		piePlot.setLabelFont(new Font("Calibri",Font.BOLD,8));
		piePlot.setLablePaint(Color.WHITE);
		piePlot.setSimpleLabels(true);
		
		LegendTitle lt = chart.getLegend();
		lt.setItemLabelPadding(new RectangleInsets(0,0,0,0,));
		lt.setLegendItemGraphicEdge(RectangleEdge.TOP);
		lt.setLegendItemGraphicPadding(new RectangleInsets(0,0,0,0));
		lt.setItemPaint(new Font("Calibri",Font.BOLD,8));
		
		
		
		
	}
	
}
