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

## Publish with GitHub Pages

1. Create a **public** GitHub repository named `CodeCraft` (or another name you prefer).
2. Upload the contents of this project to the repository root, keeping `.github/workflows/pages.yml` and `web/index.html` in place.
3. Set the repository's default branch to `main`.
4. In **Settings → Pages**, choose **GitHub Actions** as the build and deployment source.
5. Push a commit to `main` or run **Actions → Deploy CodeCraft to GitHub Pages → Run workflow**.
6. GitHub will show the published URL under **Settings → Pages**. It will usually look like `https://YOUR-USERNAME.github.io/CodeCraft/`.

The GitHub connection available in this session can edit files in existing repositories, but it does not expose a create-repository or Pages-settings action. So the repository creation and the one-time Pages setting must be completed in GitHub itself. After the repository exists, its files can be updated through the connected GitHub tools.

## Fabric mod build

The Fabric project targets Minecraft 26.1.2 and Java 25. Install JDK 25 and Gradle 9.4, then run `gradle build` from `fabric-mod/`. The resulting JAR is written to `fabric-mod/build/libs/`.

## Notes

- The browser code scratchpad performs a lightweight pattern check; it is not a Java compiler.
- Eaglercraft and Hytale are separate games/projects. This companion provides learning challenges and launch links; it does not redistribute their clients or assets.
