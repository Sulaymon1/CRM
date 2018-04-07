package com.skyforce.repositories;

import com.skyforce.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Sulaymon on 11.03.2018.
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findFirstByEmailOrPhoneNumber(String email, String phoneNumber);
    Optional<Member> findFirstById(Long id);
}
