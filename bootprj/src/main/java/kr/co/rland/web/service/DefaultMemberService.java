package kr.co.rland.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.rland.web.entity.Member;
import kr.co.rland.web.repository.MemberRepository;

@Service
public class DefaultMemberService implements MemberService {

	@Autowired
	private MemberRepository repository;
	
	@Override
	public boolean isValidMember(String uid, String pwd) {

		Member member = repository.findByUserName(uid);
		
		if(member == null){
			System.out.println("아뒤 널");
			return false;
		}
		else if(!member.getPwd().equals(pwd)) {
			System.out.println("패스워드 지랄");
			return false;
		}
		
		return true;
	}

}
