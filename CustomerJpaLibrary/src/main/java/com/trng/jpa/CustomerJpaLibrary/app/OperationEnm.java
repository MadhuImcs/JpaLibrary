package com.trng.jpa.CustomerJpaLibrary.app;

public enum OperationEnm {
	ADD(1), UPDATE(3), SELECT(2), REMOVE(4), ADDORDER(5), UPDATEORDER(7),SELECTORDER(6), REMOVEORDER(8), EXIT(9), UNKNOWN(-1);

	private int option;

	OperationEnm(int option) {
		this.option = option;
	}

	public int getOption() {
		return option;
	}

	public static OperationEnm getMatchingOperation(int option) {
		for (OperationEnm operation : OperationEnm.values()) {
			if (operation.getOption() == option) {
				return operation;
			}
		}

		return UNKNOWN;
	}
}
