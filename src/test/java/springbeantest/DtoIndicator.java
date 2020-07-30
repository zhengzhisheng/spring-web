package springbeantest;

import java.io.Serializable;


public class DtoIndicator implements Serializable {


		/**
	 * 
	 */
	private static final long serialVersionUID = -7165649562634472568L;
		//指标名称
		private String indicatorName;
		//指标
		private String indicator;
		public String getIndicatorName() {
			return indicatorName;
		}
		public void setIndicatorName(String indicatorName) {
			this.indicatorName = indicatorName;
		}
		public String getIndicator() {
			return indicator;
		}
		public void setIndicator(String indicator) {
			this.indicator = indicator;
		}

		public String toString(){
			System.out.println(indicatorName);
			return indicatorName;
		}

}
