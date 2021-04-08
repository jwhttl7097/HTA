package day4;

public class UserArrayRepository implements UserRepository{

	private User[] db = new User[100];
	private int position = 0;
		
	public UserArrayRepository() {
		db[position++] = new User("hong", "홍길동");
		db[position++] = new User("kim", "김유신");
		db[position++] = new User("lee", "이순신");
	}
	


	@Override
	public void saveUser(User user) {
		db[position++] = user;
	}	//구현부 안에 수행문이 하나도 없어도 구현부가 있으면 구현부인 것


	@Override
	public void removeUser(String id) {
		
	}

	@Override
	public void updateUser(User user) {
		User savedUser = this.getUserById(user.getId());
		if (savedUser != null) {
			savedUser.setId(user.getId());
			savedUser.setName(user.getName());
		}
	}

	@Override
	public User getUserById(String id) {
		User user = null;
		
		for (User item : db) {
			if(item == null) {
				break;
			}
			
			if(item.getId().equals(id)) {
				user = item;
				break;
			}
		}
		
		return user; 
		
		/*
		 * 반환타입이 있을 경우 
		 * 타입명 변수명 = null;
		 * return 변수명;
		 */
	}

	
}
