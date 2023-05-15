package Command;

class CommandInvoker {
    private final Command command;

    public CommandInvoker(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}