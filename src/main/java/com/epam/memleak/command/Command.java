package com.epam.memleak.command;

import com.epam.memleak.user.User;

public interface Command {

    void execute(final User user);

    void report(final User user);

}
