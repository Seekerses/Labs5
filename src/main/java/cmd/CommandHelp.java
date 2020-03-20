package cmd;

/**
 * Get info about all commands
 *
 * @author Alexandr
 */

public class CommandHelp implements Command {

    @Override
    public void execute(String[] args){

        System.out.println("help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "insert key {element} : добавить новый элемент с заданным ключом\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_key key : удалить элемент из коллекции по его ключу\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                "history : вывести последние 7 команд (без их аргументов)\n" +
                "replace_if_greater key {element} : заменить значение по ключу, если новое значение больше старого\n" +
                "min_by_name : вывести любой объект из коллекции, значение поля name которого является минимальным\n" +
                "group_counting_by_coordinates : сгруппировать элементы коллекции по значению поля coordinates, вывести количество элементов в каждой группе\n" +
                "filter_less_than_manufacturer manufacturer : вывести элементы, значение поля manufacturer которых меньше заданного");
    }

    /**
     * get name of command
     *
     * @return String
     */

    public String toString(){
        return "help";
    }
}