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
  personal data, private planning, or production payloads in this public
  repository. Non-secret identifiers required by official configuration may
  be versioned; that does not authorize publishing private planning.
- The future application baseline is zero analytics and zero tracking SDKs.
- AI access, account handling, billing, deletion, and Play distribution remain
  gated work. This repository baseline does not claim that any of them is
  implemented or approved.
- The package name reserved for the future scaffold is `dev.lcv.astrologo`;
  its presence here is documentation, not evidence of an Android build.

## Current automation baseline

- GitHub CodeQL Default Setup analyzes Actions and JavaScript/TypeScript;
  no repository-managed advanced CodeQL workflow is needed. Native Code
  Quality analyzes the inert JavaScript probe, not a future Android app.
- Dependency Review evaluates pull requests, including retargeting to `main`.
- Zizmor analyzes workflow security and uploads SARIF.
- OpenSSF Scorecard observes the default branch and uploads SARIF without
  external result publication; it is not a pull-request gate.
- Dependabot checks GitHub Actions every day, including weekends, at 05:00 in
  fixed UTC-03:00, with a seven-day cooldown except for `actions/*` and
  `github/*`. Minor/patch updates are grouped; majors remain separate PRs.
  The repository-local official GitHub CLI workflow arms native exact-head
  auto-merge for all same-repository Dependabot PRs, subject to native checks
  and rules, without a central controller, merge queue, or manual bot review.
  Gradle coverage will be added only with a real Gradle project.
  Security updates have their own group and do not wait for the version-update
  schedule or cooldown. If one member fails, diagnose it and adjust native
  grouping so other fixes can proceed through the required checks.
- The official Linear Release Action and CLI v0.18.0 record `main` commit
  history in the dedicated continuous pipeline, using the existing
  `linear-release` environment and native `queue: max`. This records repository
  history, not proof of an Android release or a Pages deployment; a sync
  failure fails that workflow and is not hidden.
- GitHub Pages deploys only the sanitized `site/` directory to
  `https://astrologo-android.lcv.dev` and excludes it from search indexing.
  Pull requests build the Pages artifact; only `main` push/manual runs deploy.
- `publish-play.yml`, dispatched manually, builds the release App Bundle, sends
  it to the chosen Google Play track and refuses to publish when the digest Play
  received is not the artifact the job built. The release notes travel with it,
  from `play/release-notes/pt-BR.txt`, because the API takes them in the track
  update and a publication without them reaches the store with an empty "what's
  new". A `release_status` input carries `completed` or `draft`: an app that has
  never been published only accepts `draft` on the public track, and that first
  publication is finished in the Play Console. A production publication also
  records a GitHub Release with tag `vXX.XX.XX`, carrying the universal APK that
  Google Play generated and signed with the app signing key — the same binary the
  store distributes — plus `SHA256SUMS` and a provenance attestation.
- `record-play-release.yml`, also dispatched manually, records that GitHub
  Release for a version **already** on the store, given its `versionCode`,
  without rebuilding or re-uploading anything. It is the path after a first
  publication is completed in the Console, when the publishing workflow has
  already finished and re-dispatching it would only re-upload a `versionCode`
  Play refuses. Measured on 20/09/2026 in calculadora-android: Play makes the
  universal APK available as soon as it processes the bundle, before any rollout.

  This repository has no application yet, so `play/release-notes/pt-BR.txt` does
  not exist and the publishing workflow stops before building, saying so. That is
  the intended gate, not a defect: nothing here is ready to reach a store.

The deliberately inert
[`quality/code-quality-probe.js`](quality/code-quality-probe.js) gives GitHub
Code Quality one supported-language target before application source exists.
It is never loaded by Pages or any production runtime and does not represent
Kotlin or Android coverage.

Every external GitHub Action is pinned to a full commit SHA directly in its
workflow. The third-party inventory is in [`THIRDPARTY.md`](THIRDPARTY.md).

This scaffold has no application CI/build or npm/Gradle dependencies. Its
applicable PR checks are `Build Pages artifact`, `Dependency Review`, and
`Run zizmor`, alongside the effective native security rules. A repository-local
required-check ruleset must be separately approved and verified before the
new auto-merge workflow is admitted; no remote setting is implied by these
source changes. Future Android implementation remains separately gated.

Official references: [Dependabot automation](https://docs.github.com/en/code-security/tutorials/secure-your-dependencies/automate-dependabot-with-actions),
[CodeQL Default Setup](https://docs.github.com/en/code-security/code-scanning/enabling-code-scanning/configuring-default-setup-for-code-scanning),
and [native workflow concurrency](https://docs.github.com/en/actions/how-tos/write-workflows/choose-when-workflows-run/control-workflow-concurrency).

## Contributing, security, and license

Read [`CONTRIBUTING.md`](CONTRIBUTING.md) before proposing a change. Report
security concerns only through the private route in
[`SECURITY.md`](SECURITY.md).

The original content is licensed under the GNU Affero General Public License,
version 3 or any later version (`AGPL-3.0-or-later`). See
[`LICENSE`](LICENSE), [`NOTICE`](NOTICE), and
[`THIRDPARTY.md`](THIRDPARTY.md). Contributor-owned material also follows the
repository-local [`INBOUND.md`](INBOUND.md) policy; no copyright transfer is
implied by opening a pull request.
