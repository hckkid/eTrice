package org.eclipse.etrice.integration.SendingDataByValueTest;




public class PingPongData {
	
	
	//--------------------- attributes
	protected byte i8Val;
	protected short i16Val;
	protected int i32Val;
	protected char charVal;
	protected float f32Val;
	protected double f64Val;
	protected String stringVal;
	protected int[] arrayFromInt32 = {1,2,3,4,5};
	protected PingPongDataDeep ownType;
	//--------------------- attribute setters and getters
	public void setI8Val (byte i8Val) {
		 this.i8Val = i8Val;
	}
	public byte getI8Val () {
		return this.i8Val;
	}public void setI16Val (short i16Val) {
		 this.i16Val = i16Val;
	}
	public short getI16Val () {
		return this.i16Val;
	}public void setI32Val (int i32Val) {
		 this.i32Val = i32Val;
	}
	public int getI32Val () {
		return this.i32Val;
	}public void setCharVal (char charVal) {
		 this.charVal = charVal;
	}
	public char getCharVal () {
		return this.charVal;
	}public void setF32Val (float f32Val) {
		 this.f32Val = f32Val;
	}
	public float getF32Val () {
		return this.f32Val;
	}public void setF64Val (double f64Val) {
		 this.f64Val = f64Val;
	}
	public double getF64Val () {
		return this.f64Val;
	}public void setStringVal (String stringVal) {
		 this.stringVal = stringVal;
	}
	public String getStringVal () {
		return this.stringVal;
	}public void setArrayFromInt32 (int[] arrayFromInt32) {
		 this.arrayFromInt32 = arrayFromInt32;
	}
	public int[] getArrayFromInt32 () {
		return this.arrayFromInt32;
	}public void setOwnType (PingPongDataDeep ownType) {
		 this.ownType = ownType;
	}
	public PingPongDataDeep getOwnType () {
		return this.ownType;
	}
	//--------------------- operations
	
	// default constructor
	public PingPongData() {
		i8Val = 34;
		i16Val = 24;
		i32Val = 12;
		charVal = 'c';
		f32Val = 4711.0815f;
		f64Val = 47114711.08150815;
		stringVal = "Du alter Depp !";
		ownType = new PingPongDataDeep();
	}
	
	// deep copy
	public PingPongData deepCopy() {
		PingPongData copy = new PingPongData();
		copy.i8Val = i8Val;
		copy.i16Val = i16Val;
		copy.i32Val = i32Val;
		copy.charVal = charVal;
		copy.f32Val = f32Val;
		copy.f64Val = f64Val;
		copy.stringVal = stringVal;
		for (int i=0;i<5;i++){copy.arrayFromInt32[i]=arrayFromInt32[i];}
		copy.ownType = ownType.deepCopy();
		return copy;
	}
};
