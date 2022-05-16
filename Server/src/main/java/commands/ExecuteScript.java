package commands;

import database.DatabaseManager;
import dto.Request;
import util.transceiving.Sender;

import java.net.SocketAddress;

/**
 * Класс команды ExecuteScript
 */
public class ExecuteScript extends Command {
    public ExecuteScript(Sender sender, DatabaseManager databaseManager) {
        this.name = "execute_script";
        this.help = "Считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит";
        this.argsNumber = 0;
        this.sender = sender;
        this.databaseManager = databaseManager;
    }

    @Override
    public void execute(SocketAddress socketAddress, Request request) {
        ;
    }
}
