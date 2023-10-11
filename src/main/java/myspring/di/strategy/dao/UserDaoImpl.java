package myspring.di.strategy.dao;

import java.util.Arrays;
import java.util.List;

import myspring.user.vo.UserVO;

public class UserDaoImpl implements UserDao {
	List<UserVO> userList;
	
	public UserDaoImpl() {
		userList = Arrays.asList(
				new UserVO(1L,"gildong", "홍길동", "남", "마곡"),
				new UserVO(2L,"dooly", "둘리", "남", "마곡나루"));
	}
	
	@Override
	public UserVO read(int index) {
		return userList.get(index);
	}

	@Override
	public List<UserVO> readAll() {		
		return userList;
		// 나는 바보다 나 김경혜는 바보다 움하하하하ㅏ핳하 엥혀허ㅓㅓ어 ㅕ어어어엫 오오
		// 느낌이 신기한데??? 이거 탐나는데?? 나 주라 주라 줘어어어어어
	}	


}
