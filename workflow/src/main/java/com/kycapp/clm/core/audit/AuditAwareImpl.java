package com.kycapp.clm.core.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditAwareImpl implements AuditorAware<String> {
@Override
    public Optional<String> getCurrentAuditor() {
      //  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    //    if (authentication == null ){
            return Optional.ofNullable("Anonymous User");
    //    }
     //   return Optional.ofNullable( SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
   }
}