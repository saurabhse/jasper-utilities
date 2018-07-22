public class BarChartCustomizer implements JRChartCustomizer{
	
	public void customize(JfreeChart chart,JRChart jasperChart) {
		CategoryPlot plot = chart.getCategoryPlot();
		BarRenderer rd = (BarRenderer) plot.getRenderer();
		rd.setmaximumBarWidth(.12);
	}
	
	public void customize(JfreeChart chart,JRChart jasperChart) {
		CategoryPlot plot = chart.getCategoryPlot();
		CategoryAxis axis = plot.getDomainAxis();
		axis.setCategoryMargin(-0.5);
		ValueAxis valueAxis = plot.getRangeAxis();
		valueAxis.setAutoRange(true);
		valueAxis.setUpperMargin(0.3);
		valueAxis.setLowerMargin(0.3);
		BarRenderer rd = (BarRenderer) plot.getRenderer();
		rd.setItemMargin(-4);
		plot.addRangeMarker(new valueMarker(0.0),Layer.FOREGROUND);
		
	}
	
	public void customize(JfreeChart chart,JRChart jasperChart) {
		CategoryPlot plot = chart.getCategoryPlot();
		CategoryAxis axis = plot.getDomainAxis();
		axis.setCategoryMargin(0.05);
		ValueAxis valueAxis = plot.getRangeAxis();
		valueAxis.setAutoRange(true);
		valueAxis.setUpperMargin(0.3);
		valueAxis.setLowerMargin(0.3);
		BarRenderer rd = new BarRenderer(){
			@Override
			public Paint getItemPaint(int row,int col) {
				CategoryDataset catDataset = getPlot().getDataset();
				String rowKey = (String)catDataset.getRowKey(row);
				String colKey = (String)catDataset.getColumnKey(col);
				
				double value = catDataset.getValue(rowKey,colKey).doubleValue();
				if(value < 0.0) {
					return Color.decode("#FFFFFF");
					
				}else {
					return Color.decode("#000000");
				}
			}
		};
		rd.setShadowVisible(false);
		DecimalFormat decimalformat1 = new DecimalFormat("#0.0");
		rd.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}"),decimalformat1);
		rd.setSeriesItemLabelFont(0, new Font("Calibri",Font.PLAIN,8));
		rd.setBaseItemlabelsVisible(true);
		plot.addRangeMarker(new valueMarker(0.0),Layer.FOREGROUND);
		plot.setRenderer(rd);
		
		
	}
	
	public void customize(JfreeChart chart,JRChart jasperChart) {
		CategoryPlot plot = chart.getCategoryPlot();
		CategoryAxis axis = plot.getDomainAxis();
		axis.setCategoryMargin(0.05);
		ValueAxis valueAxis = plot.getRangeAxis();
		valueAxis.setAutoRange(true);
		valueAxis.setUpperMargin(0.3);
		valueAxis.setLowerMargin(0.3);
		CategoryItemRenderer rend = chart.getCategoryPlot().getRenderer();
		ItemLabelPosition i = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12,TextAnchor.CENTER_LEFT,TextAnchor.CENTER_LEFT,-Math.PI/2);
		rend.setBasePositiveItemLabelPosition(i);
		ItemLabelPosition i1 = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6,TextAnchor.TOP_CENTER,TextAnchor.CENTER,-Math.PI/2);
		rend.setBaseNegativeItemLabelPosition(i1);
		BarRenderer rd = (BarRenderer) plot.getRenderer();
		rd.setItemMargin(-4);
		plot.addRangeMarker(new valueMarker(0.0),Layer.FOREGROUND);
		plot.setRenderer(rd);
	}
	
	public void customize(JfreeChart chart,JRChart jasperChart) {
		CategoryPlot plot = chart.getCategoryPlot();
		CategoryAxis axis = plot.getDomainAxis();
		axis.setCategoryMargin(0.05);
		BarRenderer rd = new BarRenderer(){
			@Override
			public Paint getItemPaint(int row,int col) {
				CategoryDataset catDataset = getPlot().getDataset();
				String rowKey = (String)catDataset.getRowKey(row);
				String colKey = (String)catDataset.getColumnKey(col);
				
				if(colKey.equalsIgnoreCase("a")) {
						return Color.decode("#FFFFFF");
					
				}else {
					return Color.decode("#000000");
				}
			}
		};
		DecimalFormat decimalformat1 = new DecimalFormat("#0.0");
		rd.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}"),decimalformat1);
		rd.setSeriesItemLabelFont(0, new Font("Calibri",Font.PLAIN,6));
		ItemLabelPosition i = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12,TextAnchor.BOTTOM_CENTER);
		rd.setBasePositiveItemLabelPosition(i);
		ItemLabelPosition i1 = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6,TextAnchor.TOP_CENTER);
		rd.setBaseNegativeItemLabelPosition(i1);
		axis.setCategoryMargin(-0.01);
		ValueAxis valueAxis = plot.getRangeAxis();
		valueAxis.setAutoRange(true);
		valueAxis.setUpperMargin(0.3);
		valueAxis.setLowerMargin(0.3);
		
		rd.setBaseItemlabelPaint(Color.BLACK);
		rd.setBaseItemLabelsBisible(true);
		
		rd.setItemMargin(-4);
		rd.setMaximumWidth(.12);
		rd.setShadowVisible(true);
		plot.addRangeMarker(new valueMarker(0.0),Layer.FOREGROUND);
		plot.setRenderer(rd);
		
	}
}
