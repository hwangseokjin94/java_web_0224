package command;

public class ActionForward {

	// 1. 응답View
	// 2. 이동방법(redirect, forward)
	
	// Field
	private String path;  // 디폴트 null
	private boolean isRedirect;  // 디폴트 false (기본값은 forward)
	
	// Method
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
}
