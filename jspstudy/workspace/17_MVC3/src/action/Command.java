package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	//이런매소드를 많들어라하는게 인터페이스 생김새를 가지고 만들기이다.
	//모든 모델들의 모습을 통합하기위해 만듬.
	public String  execute(HttpServletRequest request , HttpServletResponse response);
}
