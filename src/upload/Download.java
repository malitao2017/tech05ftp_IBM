package upload;

import com.ibm.crl.webbr.common.ftp.serviceimp.FTPTools;


public class Download {
	public static void main(String[] args){
		test();
	}
	public static void test(){
		try {
			FTPTools myFtp = new FTPTools("GBK");
			myFtp.connect("123.57.204.106", 21, "test", "tsingsoft2015");
			//File localFile = new File(localpathfilename);
			myFtp.download("/data/101/sj/20150914.csv", "d:/20150914.csv");
			System.out.println( " DOWNLOAD success£¡");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
