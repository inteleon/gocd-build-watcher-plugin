package com.github.gmazzo.gocd.email;

import com.github.gmazzo.gocd.model.Message;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class EmailNotifierTest {
    private EmailNotifier notifier;

    @Before
    public void setUp() {
        String username = System.getenv("GMAIL_ACCOUNT");
        String password = System.getenv("GMAIL_PASSWORD");

        assert username != null : "Missing GMAIL_ACCOUNT environment variable!";
        assert password != null : "Missing GMAIL_PASSWORD environment variable!";

        notifier = new EmailNotifier("smtp.gmail.com", 465, username, password, true, username, null);
    }

    @Test
    public void testSendMessage() {
        notifier.sendMessage("gmazzo65@gmail.com", new Message.Builder()
                .text("Hello gmazzo65@gmail.com! this a direct message " + new Date())
                .link("http://google.com")
                .tag("AAA", "Text AAA")
                .longTag("BBB", "Text BBB")
                .tag("CCC", "Text CCC")
                .tag("DDD", "Text DDD")
                .longTag("EEE", "Text EEE")
                .tag("FFF", "Text FFF")
                .build());
    }

}