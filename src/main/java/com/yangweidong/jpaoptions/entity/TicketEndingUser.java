package com.yangweidong.jpaoptions.entity;


import javax.persistence.*;

@Entity
@Table(name = "t_ticket_ending")
public class TicketEndingUser {
    @Id
    @Column(name = "c_ticket_ending_user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketEndingUserId;

    @Column(name = "c_ticket_ending_user_name")
    private String ticketEndingUserName;

    @Column(name = "c_ticket_ending_user_password")
    private String ticketEndingUserPassword;

    @Column(name = "c_ticket_ending_user_token")
    private String ticketEndingUserToken;

    public String getTicketEndingUserToken() {
        return ticketEndingUserToken;
    }

    public void setTicketEndingUserToken(String ticketEndingUserToken) {
        this.ticketEndingUserToken = ticketEndingUserToken;
    }

    public int getTicketEndingUserId() {
        return ticketEndingUserId;
    }

    public void setTicketEndingUserId(int ticketEndingUserId) {
        this.ticketEndingUserId = ticketEndingUserId;
    }

    public String getTicketEndingUserName() {
        return ticketEndingUserName;
    }

    public void setTicketEndingUserName(String ticketEndingUserName) {
        this.ticketEndingUserName = ticketEndingUserName;
    }

    public String getTicketEndingUserPassword() {
        return ticketEndingUserPassword;
    }

    public void setTicketEndingUserPassword(String ticketEndingUserPassword) {
        this.ticketEndingUserPassword = ticketEndingUserPassword;
    }
}
