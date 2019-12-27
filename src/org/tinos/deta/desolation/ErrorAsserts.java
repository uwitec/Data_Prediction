package org.tinos.deta.desolation;

import org.tinos.deta.statistic.LYG4DWithDoubleQuickSort4D;

public class ErrorAsserts{
	//����������ڽ��о������ƥ�� ��ȡ�����Ƿ����ںϸ�״̬��
	//inputValue �����۲�ɷݡ�
	//matchValues �����۲����������
	//scale�������ȡ�
	//sortStackRange ������������ͬ�������ȷ����ջ������ʺϼ��ٵݹ�������
	public boolean getErrorAsserts(double inputValue, double[] matchValues, double scale) {
		double max= inputValue+ scale;
		double min= inputValue- scale;
		for(int i= 0; i< matchValues.length; i++) {
			if(!(matchValues[i]> max|| matchValues[i]< min)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean getBinaryErrorAsserts(double inputValue, double[] matchValues
			, double scale, int sortStackRange) {
		matchValues= new LYG4DWithDoubleQuickSort4D().sort(matchValues, sortStackRange);
		double max= inputValue+ scale;
		double min= inputValue- scale;
		int big= matchValues.length;
		int mid= matchValues.length/ 2;
		while(mid>= 0) {
			if(!(matchValues[mid]> max|| matchValues[mid]< min)) {
				return true;
			}
			if(inputValue> matchValues[mid]) {
				mid= (mid+ big)/ 2;
			}else {
				mid= mid/ 2;
				big= mid;
			}
		}
		return false;
	}
}