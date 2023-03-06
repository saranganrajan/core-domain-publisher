package com.saranganrajan.apps.coredomainpublisher.dto.domain;

import com.saranganrajan.apps.coredomainpublisher.dto.Policy;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LinkedPolicy {
    private String linkType;
    private Policy policy;
}
