package com.knubisoft.tasks.algorithm.luckyticket;

public class LuckyTicketImpl implements LuckyTicket {
    @Override
    public boolean checkIsLuckyTicket(String ticket) {
        if (ticket == null || ticket.length() < 6 || ticket.length() > 8)
            return false;
        try {
            Integer.parseInt(ticket);
        } catch (NumberFormatException e) {
            return false;
        }

        for (int i = 0; i < ticket.length() / 2; i++) {
            if (!(ticket.charAt(i) == ticket.charAt(ticket.length() -1 - i)))
                return false;
        }
        return true;
    }
}
