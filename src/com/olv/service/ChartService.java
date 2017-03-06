package com.olv.service;

import java.awt.Font;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import com.olv.domain.Options;
import com.olv.domain.Theme;

public class ChartService {
	private VoteService voteService;
	/*
	 * ע��voteService
	 */
	public void setVoteService(VoteService voteService) {
		this.voteService = voteService;
	}
	/*
	 * ����Ʊ��ͳ��ͼ��
	 */
     public void getVoteChart(Theme theme){
    	
    	DefaultPieDataset data = getVoteDataSet(theme);
 		JFreeChart chart = ChartFactory.createPieChart3D("ͶƱ�ֲ�ͼ", // ͼ�����
 				data, true, // �Ƿ���ʾͼ��
 				true, true);
 		// ��������;
 		PiePlot plot =  (PiePlot) chart.getPlot();
 		chart.getTitle().setFont(new Font("����", Font.BOLD, 25));
 		plot.setLabelFont(new Font("����", Font.BOLD, 16));
 		plot.setBackgroundAlpha(1.00f);
 		// ����ͼ���ļ�
 		FileOutputStream chartImg = null;
 		try {
 			chartImg = new FileOutputStream("D:\\Ӧ�ó���\\web\\apache-tomcat-8.0.36\\webapps\\OnlineVote\\images\\pie3DChart.jpg");
 			ChartUtilities.writeChartAsJPEG(chartImg, 1, chart, 400, 300, null);
 			
 		} catch (Exception e) {
 			e.printStackTrace();
 		} finally {
 			try {
 				chartImg.close();
 			} catch (Exception e) {
 			}
 		}
     }
     public DefaultPieDataset  getVoteDataSet(Theme theme){
    	DefaultPieDataset dataset = new DefaultPieDataset();
    	 //�����ݿ���ȡ����
 	  	Set<Object> set=theme.getOptionses();
 	  	Iterator<Object> it=set.iterator();
 	  	while(it.hasNext()){
 	  	    Options options=(Options) it.next();
 	  	    if(theme.getType()==1){
 	  	    	//��������
 	 	  	    dataset.setValue(options.getDetails(), options.getVotes().size());
            }else{
 	  	    	//ͼƬ����
 	 	  	    dataset.setValue(options.getKey(), options.getVotes().size());
 	  	    }
 	  	 }
    	 return dataset;
     }
     /*
      * ���ɵ���ͳ��ͼ��
      */
      public void getAddressChart(Theme theme){
      	
      	DefaultPieDataset data = getAddressDataSet(theme);
   		JFreeChart chart = ChartFactory.createPieChart3D("�����ֲ�ͼ", // ͼ�����
   				data, true, // �Ƿ���ʾͼ��
   				true, true);
   		// ��������;
   		PiePlot plot =  (PiePlot) chart.getPlot();
   		chart.getTitle().setFont(new Font("����", Font.BOLD, 25));
   		plot.setLabelFont(new Font("����", Font.BOLD, 16));
   		plot.setBackgroundAlpha(1.00f);
   		// ����ͼ���ļ�
   		FileOutputStream chartImg = null;
   		try {
   			chartImg = new FileOutputStream("D:\\Ӧ�ó���\\web\\apache-tomcat-8.0.36\\webapps\\OnlineVote\\images\\bar3DChart.jpg");
   			ChartUtilities.writeChartAsJPEG(chartImg, 1, chart, 400, 300, null);
   			
   		} catch (Exception e) {
   			e.printStackTrace();
   		} finally {
   			try {
   				chartImg.close();
   			} catch (Exception e) {
   			}
   		}
       }
       public DefaultPieDataset  getAddressDataSet(Theme theme){
    	   DefaultPieDataset dataset = new DefaultPieDataset();
      	 //�����ݿ���ȡ����
    	  List<Object> list=voteService.getAddressVoteSum(theme);
     	  for (int i = 0; i < list.size(); i++) {
 		  Object[] objects=(Object[]) list.get(i);
			  dataset.setValue(objects[1].toString(),Integer.parseInt(objects[0].toString()));
		}
      	 return dataset;
       }
}
