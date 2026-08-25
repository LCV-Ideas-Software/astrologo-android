# Astrologo Android

[![OpenSSF Best Practices](https://www.bestpractices.dev/projects/14228/badge)](https://www.bestpractices.dev/projects/14228)

Public delivery repository for the Android edition of **Astrologo**, maintained
by LCV Ideas & Software. The repository is currently an operational,
governance, and supply-chain baseline; it does not contain a functional
Android application, Gradle project, signing configuration, production
dependency, or published app release yet.

## Canonical tracking

| Surface | Canonical resource |
| --- | --- |
| GitHub repository | [`LCV-Ideas-Software/astrologo-android`](https://github.com/LCV-Ideas-Software/astrologo-android) |
| GitHub Project | [Project #19 — astrologo-android](https://github.com/orgs/LCV-Ideas-Software/projects/19) |
| Linear | Team and Project `astrologo-android` |
| Bootstrap | [ASTANDR-1](https://linear.app/lcv-ideas-software/issue/ASTANDR-1/governanca-concluir-bootstrap-operacional-e-reconciliacao-do-astrologo) ↔ [GitHub Issue #1](https://github.com/LCV-Ideas-Software/astrologo-android/issues/1) |

A GitHub Issue is linked to Linear only when both resources are explicit,
unequivocal counterparts. Historical Project drafts remain drafts; this
bootstrap does not convert them in bulk.

## Public-boundary rules

- Never publish credentials, signing material, fiscal or banking records,
  personal data, private planning, production payloads, or internal
  infrastructure identifiers in this public repository.
- The future application baseline is zero analytics and zero tracking SDKs.
- AI access, account handling, billing, deletion, and Play distribution remain
  gated work. This repository baseline does not claim that any of them is
  implemented or approved.
- The package name reserved for the future scaffold is `dev.lcv.astrologo`;
  its presence here is documentation, not evidence of an Android build.

## Current automation baseline

- CodeQL analyzes GitHub Actions and the inert JavaScript probe on pull
  requests, merge groups, `main`, and a schedule.
- Dependency Review evaluates pull requests and synthetic merge groups.
- Zizmor analyzes workflow security and uploads SARIF.
- OpenSSF Scorecard observes the default branch; it is not a pull-request gate.
- Dependabot checks GitHub Actions daily. Gradle coverage will be added only
  with a real Gradle project.
- The official Linear Release Action records successful `main` history in the
  dedicated continuous pipeline.
- GitHub Pages deploys only the sanitized `site/` directory to
  `https://astrologo-android.lcv.dev` and excludes it from search indexing.

The deliberately inert
[`quality/code-quality-probe.js`](quality/code-quality-probe.js) gives GitHub
Code Quality one supported-language target before application source exists.
It is never loaded by Pages or any production runtime and does not represent
Kotlin or Android coverage.

Every external GitHub Action is pinned to a full commit SHA and inventoried in
[`THIRDPARTY.md`](THIRDPARTY.md). The generated
`.github/workflows/actions.lock` is the machine-verifiable dependency record.

## Contributing, security, and license

Read [`CONTRIBUTING.md`](CONTRIBUTING.md) before proposing a change. Report
security concerns only through the private route in
[`SECURITY.md`](SECURITY.md).

The original content is licensed under the GNU Affero General Public License,
version 3 or any later version (`AGPL-3.0-or-later`). See
[`LICENSE`](LICENSE), [`NOTICE`](NOTICE), and
[`THIRDPARTY.md`](THIRDPARTY.md).
