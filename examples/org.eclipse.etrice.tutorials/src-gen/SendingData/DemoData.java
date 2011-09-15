package SendingData;



public class DemoData {
	//--------------------- attributes
	protected int int32Val;protected byte[] int8Array = {1,2,3,4,5,6,7,8,9,10};
	protected double float64Val;protected String stringVal;
	//--------------------- attribute setters and getters
	public void setInt32Val (int int32Val) {
		 this.int32Val = int32Val;
	}
	public int getInt32Val () {
		return int32Val;
	}public void setInt8Array (byte[] int8Array) {
		 this.int8Array = int8Array;
	}
	public byte[] getInt8Array () {
		return int8Array;
	}public void setFloat64Val (double float64Val) {
		 this.float64Val = float64Val;
	}
	public double getFloat64Val () {
		return float64Val;
	}public void setStringVal (String stringVal) {
		 this.stringVal = stringVal;
	}
	public String getStringVal () {
		return stringVal;
	}
	//--------------------- operations
	
	// default constructor
	public DemoData() {
		int32Val = 4711;
		float64Val = 0.0;
		stringVal = "empty";
	}
	
	// deep copy
	public DemoData deepCopy() {
		DemoData copy = new DemoData();
		copy.int32Val = int32Val;
		for (int i=0;i<10;i++){copy.int8Array[i]=int8Array[i];}
		copy.float64Val = float64Val;
		copy.stringVal = stringVal;
		return copy;
	}
};
