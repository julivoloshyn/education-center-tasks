package com.knubisoft.tasks.algorithm.luckyticket;


public class LuckyTicketImpl implements LuckyTicket {

    @Override
    public boolean checkIsLuckyTicket(String ticket) {

        if(ticket == null){
            return false;
        }

        boolean isLucky = false;
        boolean onlyDigits = ticket.matches("[0-9]+");
        int length = ticket.length();

        if(length < 6 || length > 8 || !onlyDigits){
            isLucky = false;
        } else {

            if(isPalindrome(ticket)){
                isLucky = true;
            }
        }
        return isLucky;
    }

    private boolean isPalindrome(String ticket) {
        StringBuilder reverse = new StringBuilder();
        char[] plain = ticket.toCharArray();

        for (int i = plain.length - 1; i >= 0; i--) {
            reverse.append(plain[i]);
        }

        return (reverse.toString()).equals(ticket);
    }
}
