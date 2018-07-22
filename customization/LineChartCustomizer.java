public class LineChartCustomizer implements JRChartCustomizer{
	
	
	
	public void customize(JfreeChart chart,JRChart jasperChart) {
		CategoryPlot plot = chart.getCategoryPlot();
		CategoryAxis axis = plot.getDomainAxis();
		for(int i=0;i< plot.getCategories().size();i++) {
			String catname = (String)plot..getCategories().get(i);
			if(!(i==0 || i %6 == 0)) {
				axis.setTickLabelPaint(catname,Color.white);
			}
		}
		Shape diamond = ShapeUtilities.createDiamond(2.0F);
		CategoryItemRenderer renderer = (CategoryItemRenderer)plot.getRenderer();
		renderer.setSeriesShape(0,diamond);
		LineAndShapeRenderer l = (LineAndShapeRenderer)renderer;
		l.setuseOutlinepaint(true);
		l.setSeriesOutlinePaint(0,Color.black);
		l.setSeriesOutlineStroke(0,new BasicStroke(0.7F));
		axis.setLowerMargin(0.03);
		axis.setUpperMargin(0.03);
		
		
		
	}
	
}
