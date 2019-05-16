package  com.majianwei.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * (Dept)实体类
 *
 * @author makejava
 * @since 2019-01-29 22:24:35
 */
@Entity
@Table(name = "dept")
public class Dept extends BaseDomain {
   
                                             
                
    
    private String name;

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}