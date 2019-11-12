package com.crossyf.practice.hutool;

import lombok.Data;

/**
 * @author Created by YangFan.
 * @date 2019/11/11
 * 功能:
 */
@Data
public class Price {
    private String count;
    private String unfaxPrice;
    private String tax;
    private String faxPrice;
    private String totalUnfaxPrice;
    private String totalFaxPrice;
}
