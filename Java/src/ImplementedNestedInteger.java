import java.util.List;

public class ImplementedNestedInteger extends NestedInteger {
	
	List<NestedInteger> list;
	int val;
	boolean isInteger;
	
	public ImplementedNestedInteger(int val) {
		this.val = val;
		this.isInteger = true;
	}
	
	public ImplementedNestedInteger(List<NestedInteger> list) {
		this.list = list;
		this.isInteger = false;
	}

	@Override
	public boolean isInteger() {
		// TODO Auto-generated method stub
		return isInteger;
	}

	@Override
	public Integer getInteger() {
		// TODO Auto-generated method stub
		return val;
	}

	@Override
	public List<NestedInteger> getList() {
		// TODO Auto-generated method stub
		return list;
	}

}
