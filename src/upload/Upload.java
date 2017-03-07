package upload;

import java.io.File;

import com.ibm.crl.webbr.common.ftp.serviceimp.FTPTools;
import com.ibm.crl.webbr.common.ftp.serviceimp.SFTPUtils;

/**
 * 
 * @author heyan
 *
 */
public class Upload {
	public static void main(String[] args) {

		if (args[1].equals("0")) {
			savatoFtp(args[0]);
		} else if (args[1].equals("1")) {
			savetoSftp(args[0]);
		}
	}

	public static void savatoFtp(String localpathfilename) {
		int index = localpathfilename.lastIndexOf("/");
		String remotefilename = localpathfilename.substring(index + 1,
				localpathfilename.length());
		System.out.println("localpathfilename:" + localpathfilename);
		System.out.println("remotefilename:" + remotefilename);
		// 上传文件
		try {
			FTPTools myFtp = new FTPTools("GBK");
			myFtp.connect("10.13.3.13", 21, "hhfdc", "1qaz2wsx");
			File localFile = new File(localpathfilename);
			myFtp.upload(localFile, remotefilename);
			System.out.println(localpathfilename + " upload success！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void savetoSftp(String localpathfilename) {
		SFTPUtils sftp = new SFTPUtils("10.13.3.13", 22, "hhfdc", "1qaz2wsx");
		sftp.upload(localpathfilename, "");
	}
}
