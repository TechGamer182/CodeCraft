package dev.codecraft;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

/** In-game learning companion for the CodeCraft browser academy. */
public final class CodeCraftMod implements ModInitializer {
    private static final String PREFIX = "[CodeCraft] ";

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
            dispatcher.register(Commands.literal("codecraft")
                .executes(context -> showWelcome(context.getSource()))
                .then(Commands.literal("help").executes(context -> showHelp(context.getSource())))
                .then(Commands.literal("lesson")
                    .executes(context -> showVariablesLesson(context.getSource()))
                    .then(Commands.literal("variables").executes(context -> showVariablesLesson(context.getSource())))
                    .then(Commands.literal("conditions").executes(context -> showConditionsLesson(context.getSource())))
                    .then(Commands.literal("loops").executes(context -> showLoopsLesson(context.getSource())))
                    .then(Commands.literal("methods").executes(context -> showMethodsLesson(context.getSource()))))
                .then(Commands.literal("quest").executes(context -> showQuest(context.getSource())))
                .then(Commands.literal("answer")
                    .then(Commands.argument("choice", StringArgumentType.word())
                        .executes(context -> checkAnswer(context.getSource(),
                            StringArgumentType.getString(context, "choice")))))
                .then(Commands.literal("about").executes(context -> showAbout(context.getSource())))
            )
        );
    }

    private static int showWelcome(net.minecraft.commands.CommandSourceStack source) {
        tell(source, "Welcome, developer! Your first quest awaits.");
        tell(source, "Try /codecraft help to see commands, or /codecraft quest to start.");
        return 1;
    }

    private static int showHelp(net.minecraft.commands.CommandSourceStack source) {
        tell(source, "COMMAND GUIDE");
        tell(source, "/codecraft - welcome");
        tell(source, "/codecraft lesson [variables|conditions|loops|methods] - study Java");
        tell(source, "/codecraft quest - show the beginner challenge");
        tell(source, "/codecraft answer <A|B|C> - submit your answer");
        tell(source, "/codecraft about - mod information");
        return 1;
    }

    private static int showVariablesLesson(net.minecraft.commands.CommandSourceStack source) {
        tell(source, "LESSON: VARIABLES — a variable stores a value under a name.");
        tell(source, "int diamonds = 25;");
        tell(source, "String player = \"Alex\";");
        tell(source, "boolean alive = true;");
        tell(source, "Real-world skill: choosing data types and modelling information.");
        return 1;
    }

    private static int showConditionsLesson(net.minecraft.commands.CommandSourceStack source) {
        tell(source, "LESSON: CONDITIONS");
        tell(source, "if (diamonds >= 10) { System.out.println(\"Purchase!\"); }");
        tell(source, "else { System.out.println(\"Not enough!\"); }");
        tell(source, "Real-world skill: business rules and input validation.");
        return 1;
    }

    private static int showLoopsLesson(net.minecraft.commands.CommandSourceStack source) {
        tell(source, "LESSON: LOOPS");
        tell(source, "for (int i = 0; i < 5; i++) { System.out.println(i); }");
        tell(source, "This loop runs five times: 0, 1, 2, 3, 4.");
        return 1;
    }

    private static int showMethodsLesson(net.minecraft.commands.CommandSourceStack source) {
        tell(source, "LESSON: METHODS");
        tell(source, "static int add(int a, int b) { return a + b; }");
        tell(source, "Methods package reusable logic behind a name.");
        return 1;
    }

    private static int showQuest(net.minecraft.commands.CommandSourceStack source) {
        tell(source, "QUEST 001: THE MISSING DIAMONDS");
        tell(source, "Which Java declaration correctly stores 25 diamonds?");
        tell(source, "A) int diamonds = 25;   B) String diamonds = 25;   C) diamonds int = 25;");
        tell(source, "Submit with /codecraft answer A (or B / C).");
        return 1;
    }

    private static int checkAnswer(net.minecraft.commands.CommandSourceStack source, String choice) {
        if (choice.equalsIgnoreCase("A")) {
            tell(source, "Correct! int stores whole numbers. Quest concept mastered.");
            tell(source, "Next: change the value and predict what your program will print.");
        } else {
            tell(source, "Not quite. Hint: int is the Java type for whole numbers. Try A.");
        }
        return 1;
    }

    private static int showAbout(net.minecraft.commands.CommandSourceStack source) {
        tell(source, "CodeCraft v1.0.0 · Fabric · Minecraft 26.1.2");
        tell(source, "A companion mod for the CodeCraft browser learning game.");
        return 1;
    }

    private static void tell(net.minecraft.commands.CommandSourceStack source, String message) {
        source.sendSuccess(() -> Component.literal(PREFIX + message), false);
    }
}
