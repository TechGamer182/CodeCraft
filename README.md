# CodeCraft

A browser-based learning game for Java, Minecraft Fabric development, Eaglercraft play challenges, and Hytale-inspired creator challenges.

## What's included

- `web/index.html` — standalone responsive learning game. Open it directly or publish the `web/` folder with GitHub Pages.
- `fabric-mod/` — starter Fabric mod project with `/codecraft` learning commands.
- `.github/workflows/pages.yml` — GitHub Actions workflow that deploys the `web/` folder to GitHub Pages whenever `main` is updated.

## Web features

- Java/Fabric campaign, quizzes, XP, levels, boss fight, achievements, and code scratchpad.
- Eaglercraft tab with an official-site launch option, optional embedded client URL, and gameplay challenges. No Eaglercraft game files are bundled; only embed a client you are authorized to host and trust.
- Hytale Creator Academy with six world-building, creature-behavior, procedural-generation, automation, and mod/plugin design challenges. It links to Hytale's official website and does not bundle Hytale game files.
- Progress saved locally in the browser; export your save from the home screen.



## Notes

- The browser code scratchpad performs a lightweight pattern check; it is not a Java compiler.
- Eaglercraft and Hytale are separate games/projects. This companion provides learning challenges and launch links; it does not redistribute their clients or assets.
