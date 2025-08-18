public class TaskWithBotReply {
  String task;
  String reply;

  TaskWithBotReply(String task, String reply) {
    this.task = task;
    this.reply = reply;
  }

  @Override
  public String toString() {
    return task + " - " + reply;
  }
}
