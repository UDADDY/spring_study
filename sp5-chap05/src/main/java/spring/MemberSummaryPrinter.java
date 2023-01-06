package spring;

public class MemberSummaryPrinter extends MemberPrinter {

	@Override
	public void print(Member member) {
		System.out.printf("회원 정보: 이메일=%s, 이름=%s, 비밀번호=%s", member.getEmail(), member.getName(), member.getPassword());
		System.out.println();
	}

}
