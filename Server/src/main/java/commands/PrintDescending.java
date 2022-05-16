package commands;

import commands.exceptions.IllegalArgsNumberRequestException;
import commands.exceptions.IllegalFieldWrapperRequestException;
import database.DatabaseManager;
import dto.Status;
import model.Organization;
import dto.Request;
import dto.Response;
import util.CollectionManager;
import util.transceiving.Sender;

import java.net.SocketAddress;
import java.util.Collections;
import java.util.List;

/**
 * Класс команды PrintDescending
 */
public class PrintDescending extends Command {
    public PrintDescending(Sender sender, DatabaseManager databaseManager) {
        this.name = "print_descending";
        this.help = "Вывести элементы коллекции в порядке убывания";
        this.argsNumber = 0;
        this.sender = sender;
        this.databaseManager = databaseManager;
    }

    @Override
    public void execute(SocketAddress socketAddress, Request request) {
        if (request.getArgs().length != argsNumber) throw new IllegalArgsNumberRequestException(String.valueOf(argsNumber));
        if (request.getOrganization() != null) throw new IllegalFieldWrapperRequestException("команда не принимает элемент");
        List<Organization> list = databaseManager.getSortedOrganizations();
        Collections.reverse(list);
        sender.send(socketAddress, new Response(list.isEmpty() ? "Коллекция пуста." : null, list, Status.SUCCESS));
    }
}
