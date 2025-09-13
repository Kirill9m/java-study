package rs.clone.controls;

import rs.clone.character.Enemy;
import rs.clone.character.Player;

import java.util.Scanner;

import static rs.clone.controls.Combat.fight;

public class Quest {

  private static final Scanner scanner = new Scanner(System.in);

  public static void start(Player player) {
    clearScreen();
    printTitle("=== 🐉 Dragon Slayer Quest ===");

    printlnDelay("🌄 You arrive in the town of Lumbridge. The village elder notices you and approaches...", 2000);

    printlnDelay("\n🧙 Elder: \"Greetings, brave adventurer. I have a task for you.\"", 2000);
    printlnDelay("🧙 Elder: \"A fearsome dragon has appeared near the mountains. Only a true hero can slay it.\"", 2500);

    int bonesCount = player.checkItem("Bones");
    if (bonesCount < 50) {
      printlnDelay("\n🧙 Elder: \"You are not prepared yet. You need 50 ☠️ bones to complete your training.\"", 2000);
      System.out.println("You currently have: " + bonesCount + " ☠️ bones.");
      printlnDelay("🧙 Elder: Collect more bones and come back to me!", 2000);
      return;
    }

    printlnDelay("\n🧙 Elder: \"Ah, you have enough ☠️ bones! Well done, young warrior.\"", 2000);
    printlnDelay("🧙 Elder: \"Your journey will be dangerous. Travel to the Dragon's Lair 🏔️ and prepare for battle.\"", 2000);

    travelToDragonCave();

    printlnDelay("\n🐉 A massive shadow looms ahead. You hear the dragon's roar echoing through the cave!", 3000);
    printlnDelay("\n⚔️ [You are ready to fight the dragon!]", 1500);
    System.out.println("Press Enter to continue to the battle...");
    scanner.nextLine();

    fight(player, new Enemy("Green Dragon 🐉", 75, 79, 10));

    if (player.getHealth() <= 0) {
      printlnDelay("\n💀 You were slain by the dragon... Train more and try again.", 2000);
      return;
      }else
      printlnDelay("\n🏆 Congratulations! You have slain the dragon!", 2000);
      player.addTitle("Dragon Slayer");
      printlnDelay("✨ You are now known as: " + player.getName() + " the Dragon Slayer!", 2000);


    System.out.println("\nPress Enter to return to the main menu...");
    scanner.nextLine();
  }

  private static void travelToDragonCave() {
    System.out.print("\n🌲 You journey through the dark forest ");
    for (int i = 0; i < 5; i++) {
      System.out.print("🌲");
      pause(500);
    }
    printlnDelay(" and finally arrive at the dragon's cave 🏔️...", 1500);
  }

  private static void printTitle(String title) {
    String border = "=".repeat(title.length() + 4);
    System.out.println(border);
    System.out.println("| " + title + " |");
    System.out.println(border);
  }

  private static void printlnDelay(String text, long millis) {
    System.out.println(text);
    pause(millis);
  }

  private static void pause(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  private static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
