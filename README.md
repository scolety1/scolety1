# Spencer Colety

I build developer tools, workflow applications, and data-driven experiments. My work focuses on making complex processes understandable: explicit state, traceable decisions, recoverable failures, and reproducible checks.

**[Portfolio & contact](https://spencercolety.com)**

## How I build: foundations, AI and ownership

I learned software development by writing and debugging code directly in my freshman and sophomore coursework. The progression is visible in my [C++ fundamentals archive](https://github.com/scolety1/software-development-fundamentals-spring-2024) and [Java data structures and algorithms archive](https://github.com/scolety1/data-structures-algorithms-spring-2025). Those repositories include starter and course material, so I make specific authorship claims instead of treating every file as independently written work.

Today I use AI assistance because it makes development significantly faster. I define the problem, break the work into tasks, direct the agents, review the changes and verify the behavior. AI can draft and explore; I remain responsible for architecture, source attribution, integration, tests and the decision to accept a change.

When an agent stalls, a file conflicts, a test exposes a false assumption or a workflow drifts, I go back into the code and repair the failure. [Thousand Sunny Fleet](https://github.com/scolety1/orca/blob/tsf/main/tsf/SHOWCASE.md) is the framework I am building around that workflow: progress, evidence, adoption and release are separate so fast AI-assisted work can still be reviewed and recovered.

## Start with the runnable projects

For a quick technical review, start with **Shopify Catalog QA**, **Route Reader**, or **Maintenance Loop**. Each includes a reproducible local setup, tests, and a short engineering evidence tour. Start with Catalog QA for a business tool, Route Reader for algorithms and evaluation, or Maintenance Loop for lifecycle and recovery behavior.

| Project | Engineering focus | Status |
| --- | --- | --- |
| [Shopify Catalog QA](https://github.com/scolety1/shopify-catalog-qa) | Catalog validation, import provenance, conservative comparisons, and adversarial evaluation | Runnable browser-local application |
| [Route Reader](https://github.com/scolety1/route-reader) | Trajectory clustering, temporal prediction, uncertainty, and chronological evaluation | Python research prototype with synthetic demo |
| [Maintenance Loop](https://github.com/scolety1/maintenance-loop) | Lifecycle guards, evidence reconciliation, dependency recovery, and resilient persistence | Runnable synthetic workflow demo |
| [Oddly Specific](https://github.com/scolety1/weird-talent-marketplace) | Explainable matching, hard constraints, moderation, and abstention | Runnable synthetic marketplace demo |
| [Snow Jams](https://github.com/scolety1/snow-jams) | Sensor-state inference, hysteresis, deterministic replay, and evaluation | Experimental prototype |
| [QuoteLoop](https://github.com/scolety1/quoteloop) | Quote follow-up, import reconciliation, and deterministic time-dependent behavior | Runnable synthetic workflow demo |

## Developer tooling: Thousand Sunny Fleet

An AI-assisted orchestration overlay on [Orca](https://github.com/stablyai/orca), built around a practical question: how should work from coding agents become an accepted, reviewable change?

TSF separates mission progress, evidence, adoption decisions, and release state. The project-specific work lives on the `tsf/main` branch; upstream Orca supplies the underlying development environment.

**[Engineering tour](https://github.com/scolety1/orca/blob/tsf/main/tsf/SHOWCASE.md) · [Overlay source](https://github.com/scolety1/orca/tree/tsf/main/tsf) · [Adoption and release examples](https://github.com/scolety1/orca/blob/tsf/main/tsf/test/adoption-release.test.mjs)**

The bounded adoption/release examples have been tested; the full provider-backed runtime remains in development.

## Deployed work and foundations

[Urban Kitchen Drinks](https://urbankitchenbeverage.com/) is a live restaurant beverage menu with CSV-driven updates and rule-based recommendations. [Source and engineering guide](https://github.com/scolety1/Urban-Kitchen-Wine-List/blob/main/DEVELOPER_GUIDE.md).

My [Java data structures and algorithms archive](https://github.com/scolety1/data-structures-algorithms-spring-2025) provides a smaller reading sample: trees, hashing, graphs, and a documented runnable BST example. Start with [BinarySearchTree.java](https://github.com/scolety1/data-structures-algorithms-spring-2025/blob/main/Jan30_2/src/jam30/BinarySearchTree.java); I independently wrote its [`insert`](https://github.com/scolety1/data-structures-algorithms-spring-2025/blob/main/Jan30_2/src/jam30/BinarySearchTree.java#L19) and [`inOrder`](https://github.com/scolety1/data-structures-algorithms-spring-2025/blob/main/Jan30_2/src/jam30/BinarySearchTree.java#L71) methods (confirmed November 14, 2026). That claim does not extend to the whole archive or its starter material. [Decision Labs](https://github.com/scolety1/decision-labs) groups four compact JavaScript decision models. [Information Blackout](https://github.com/scolety1/information-blackout) documents a browser-extension research experiment and its measured limitations.

## Reviewing the work

Start with each repository's README for current behavior, code entry points, run commands, and verification. Recent projects are developed with AI assistance. Provenance and source credits distinguish my project work from upstream frameworks, starter code, and coursework; the older coursework upload history does not establish independent authorship of every method.
