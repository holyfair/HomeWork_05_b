import java.io.File;
import java.io.FileFilter;

public class MyFileFillter implements FileFilter{

	private String[] ars;
	
	
	public MyFileFillter(String... ars) {
		super();
		this.ars = ars;
	}

    public boolean check(String exc) {
    	for(String str : ars) {
    		if(exc.equals(str)) {
    			return true;
    		}
    	}
    	return false;
    }
	@Override
	public boolean accept(File pathname) {
		int pointerIndex = pathname.getName().lastIndexOf(".");
		if (pointerIndex == -1) {
			return false;
		}
		String ext = pathname.getName().substring(pointerIndex + 1);
		return check(ext);
	}

}
