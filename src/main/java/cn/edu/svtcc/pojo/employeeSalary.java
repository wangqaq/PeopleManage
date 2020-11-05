package cn.edu.svtcc.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
@Getter
@Setter
@ToString
public class employeeSalary {
    private long epyslryid;
    private long epyid;
    private BigDecimal totalsalary;
    private BigDecimal currentmonthsalary;
}
