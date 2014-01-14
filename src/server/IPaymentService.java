package server;

import data.Member;

public interface IPaymentService {
	public double currentAmount(Member m);
}
