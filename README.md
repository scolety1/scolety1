# Spencer Colety

I build games, statistical decision tools and systems for coordinating AI-assisted software development. My main projects are **World Forge, Niners War Room and Thousand Sunny Fleet**.

**[Portfolio & contact](https://spencercolety.com/)**

## My main projects

### [World Forge](https://github.com/scolety1/worldforge-showcase)

My flagship game project: a single-player RPG pursuing meaningful freedom within an established world. The goal is for player actions to change the direction of the story while its lore, characters and consequences remain coherent. The first game focuses on one defined world; a reusable framework for evolving 3D story worlds is the longer-term ambition.

**In development; public overview only.** The engine, unpublished lore and implementation details remain private. The overview is not a playable release or a measure of the private project's scope.

### [Niners War Room](https://github.com/scolety1/Niners-War-Room)

A statistics-driven fantasy football decision system built around my player-ranking approach. The aim is to turn underlying football performance data into useful forecasts, then turn rankings into practical lineup, waiver, trade and draft decisions—not leave a manager with only a ranking sheet.

I shape the ranking approach, football decision criteria and recommendation explanations, combining my own implementation with AI-assisted development. **Implemented local application, still evolving.** The broader direction is a prioritized action plan for what to do next; historical coverage, predictive gains and individual workflows need their own evidence rather than a blanket accuracy claim.

### [Thousand Sunny Fleet / T.Dot](https://github.com/scolety1/orca/blob/tsf/main/tsf/SHOWCASE.md)

My system for directing large AI-assisted software projects. I think of it as an **agentic corporation**: a captain coordinates team leads and specialist workers, divides work across parallel teams, reviews results and escalates serious blockers. I use Dot as the conversational interface connected to TSF's backend; sustained overnight and multi-day execution is an ongoing reliability goal, not a promise of unattended success on every project.

**In development and used in my own workflow.** This is my account of how I use the system; the public branch and its dated tests establish their own narrower scope. TSF builds on upstream Orca and third-party tools, which retain credit for their underlying interfaces and runtime.

[TSF source on tsf/main](https://github.com/scolety1/orca/tree/tsf/main/tsf) · [Engineering tour and evidence](https://github.com/scolety1/orca/blob/tsf/main/tsf/SHOWCASE.md)

## Restaurant software: HouseOS and shipped work

**HouseOS** is my broader front-of-house restaurant platform for training, communication, staff/manager workflows, shift pickup and drop, and tipout tools. It remains in development; the public beverage website is a separate, shipped part of that restaurant work.

[Urban Kitchen Drinks](https://urbankitchenbeverage.com/) is the deployed beverage menu with preference-based wine and whiskey recommendations. I designed the restaurant workflow and directed AI-assisted development. The manager-facing workflow I describe uses familiar Google Sheets/Drive tools; the public repository documents the guest site and CSV publication path, not a public reproduction of private manager access.

[Guest-site source and engineering guide](https://github.com/scolety1/Urban-Kitchen-Wine-List/blob/main/DEVELOPER_GUIDE.md)

## How I build: foundations, AI and ownership

I learned software development by writing and debugging code directly in my freshman and sophomore coursework. The progression is visible in my [C++ fundamentals archive](https://github.com/scolety1/software-development-fundamentals-spring-2024) and [Java data structures and algorithms archive](https://github.com/scolety1/data-structures-algorithms-spring-2025). Those repositories include starter and course material, so I make specific authorship claims instead of treating every file as independently written work.

Today I use AI assistance because it makes development significantly faster. I define the problem, break the work into tasks, direct the agents, review the changes and verify the behavior. AI can draft and explore; I remain responsible for architecture, source attribution, integration, tests and the decision to accept a change.

When an agent stalls, a file conflicts, a test exposes a false assumption or a workflow drifts, I go back into the code and repair the failure. [Thousand Sunny Fleet](https://github.com/scolety1/orca/blob/tsf/main/tsf/SHOWCASE.md) is the framework I am building around that workflow: progress, evidence, adoption and release are separate so fast AI-assisted work can still be reviewed and recovered.

## Independently written code

My [Java data structures and algorithms archive](https://github.com/scolety1/data-structures-algorithms-spring-2025) provides a smaller reading sample: trees, hashing, graphs, and a documented runnable BST example. Start with [BinarySearchTree.java](https://github.com/scolety1/data-structures-algorithms-spring-2025/blob/main/Jan30_2/src/jam30/BinarySearchTree.java); I independently wrote its [`insert`](https://github.com/scolety1/data-structures-algorithms-spring-2025/blob/main/Jan30_2/src/jam30/BinarySearchTree.java#L19) and [`inOrder`](https://github.com/scolety1/data-structures-algorithms-spring-2025/blob/main/Jan30_2/src/jam30/BinarySearchTree.java#L71) methods (confirmed November 14, 2026). That claim does not extend to the whole archive or its starter material. [Decision Labs](https://github.com/scolety1/decision-labs) groups four compact JavaScript decision models. [Information Blackout](https://github.com/scolety1/information-blackout) documents a browser-extension research experiment and its measured limitations.

## Additional runnable engineering samples

[Shopify Catalog QA](https://github.com/scolety1/shopify-catalog-qa) demonstrates deterministic catalog checks and conservative comparisons. [Route Reader](https://github.com/scolety1/route-reader) explores trajectory learning with synthetic chronological evaluation. Their READMEs provide run commands, test evidence and limitations. These are AI-assisted technical samples, separate from the main project story above.

Recent projects use AI assistance; repository provenance distinguishes that work from independently written code, starter material and upstream frameworks. A passing test or a synthetic portfolio demo does not establish full production readiness.
