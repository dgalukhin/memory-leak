package com.epam.memleak2.command;

import com.epam.memleak2.user.User;

public interface Command {

    void execute(User user);
    void report(User user);

}
