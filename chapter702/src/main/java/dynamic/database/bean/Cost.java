package dynamic.database.bean;

import java.io.Serializable;

public class Cost implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cost.id
     *
     * @mbg.generated Sat Jul 21 10:40:05 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cost.money
     *
     * @mbg.generated Sat Jul 21 10:40:05 CST 2018
     */
    private Integer money;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cost
     *
     * @mbg.generated Sat Jul 21 10:40:05 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cost.id
     *
     * @return the value of cost.id
     *
     * @mbg.generated Sat Jul 21 10:40:05 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cost.id
     *
     * @param id the value for cost.id
     *
     * @mbg.generated Sat Jul 21 10:40:05 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cost.money
     *
     * @return the value of cost.money
     *
     * @mbg.generated Sat Jul 21 10:40:05 CST 2018
     */
    public Integer getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cost.money
     *
     * @param money the value for cost.money
     *
     * @mbg.generated Sat Jul 21 10:40:05 CST 2018
     */
    public void setMoney(Integer money) {
        this.money = money;
    }

	public Cost(Integer money) {
		super();
		this.money = money;
	}

	public Cost() {
		super();
	}
    
}