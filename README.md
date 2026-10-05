# Astrologo Android

[![OpenSSF Best Practices](https://www.bestpractices.dev/projects/14228/badge)](https://www.bestpractices.dev/projects/14228)

Public delivery repository for the Android edition of **Astrologo**, maintained
by LCV Ideas & Software. The repository is currently an operational,
governance, and supply-chain baseline, with the initial Gradle project and the
Play publishing pipeline (ASTANDR-7): one `:app` module with a manifest and no
application code. It does not contain a functional Android application,
signing configuration, production dependency, or published app release yet.

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
- The package name is `dev.lcv.astrologo`, the `namespace` and
  `applicationId` of the initial `:app` module, which has no application code
  yet.

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
  It also checks the Gradle project, with the same daily schedule, cooldown
  and minor/patch grouping.
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
  Play uses — plus `SHA256SUMS` and a provenance attestation. Both entrypoints
  require the read-only production releases API to report `PUBLISHED` with the
  exact source versionCode in `activeArtifacts` before downloading/recording.
  A completed edit alone is not publication: the producer records no GitHub
  Release while Google review/manual publication remains pending, preserving
  its committed version for later recording. The native `PUBLISHED` lifecycle
  also includes halted/resumable releases; Google controls current rollout and
  availability, which these notes do not independently guarantee. Production
  recording requires `PLAY_RELEASE_TOKEN` before Google authentication, rejects
  existing tags/drafts before upload, and atomically creates the tag at this
  publishing run's exact source SHA. Native tag readbacks precede asset upload
  and publication. Both Play entrypoints share this repository's `play-release`
  concurrency group with native `queue: max`: up to 100 pending operations are
  retained; additional runs are canceled when the queue is full. This does not
  serialize maintainer API operations. Asset uploads use the validated native
  upload URL returned for this exact draft ID, and final publication patches
  that same ID. A deleted/replaced or retagged draft fails identity checks;
  writes never re-resolve a replacement draft by tag. The same-ID publication
  PATCH explicitly supplies the tag and full source target and validates both
  in its response; omitted fields are not assumed stable. A failed recording
  preserves its draft/tag and reports
  their identity for operator review before retry; recovery must never re-upload
  an already committed versionCode.
- `record-play-release.yml`, also dispatched manually, records that GitHub
  Release for a version **already** on the store, given its `versionCode` and
  the `publish_run_id` that uploaded it, without rebuilding or re-uploading.
  The native Actions API verifies the repository, workflow, exact source SHA
  and a successful Play upload/commit step across all native attempts of that run. A later APK download
  failure or failed rerun does not erase that durable commit; a failed legacy combined step
  remains unproven and is rejected. The publisher records commit success before
  its separate APK download step. A distinct native step confirms completed-
  production intent; it never substitutes for the Google lifecycle read. A
  successful legacy upload or first draft later promoted in the Console can
  qualify through the verified producer source and current production
  `PUBLISHED`/active-version proof. The recorder checks out that exact SHA and
  verifies its version and `applicationId` against `PLAY_PACKAGE_NAME` before
  Google authentication, preserving that package for subsequent calls.
  Existing tags and Releases are rejected. The native Git reference API creates
  the exact tag atomically before the native Release API creates an identified
  draft. Its tag is verified before assets are uploaded and publication occurs.
  On failure, the created tag and draft ID are reported and preserved for
  operator review before retry. GitHub has no conditional deletion API that can
  exclude a concurrent maintainer publication or tag update; no Release/ref is
  deleted. No existing tag is rewritten.
  A repository-local `PLAY_RELEASE_TOKEN` with Contents and Workflows write
  access is required for the historical tag/Release write and is checked before
  Google authentication. Collision guards also use the push-capable dedicated
  token because the native Release list exposes drafts only to users with push
  access. Actions/checkout/attestation reads retain the native `GITHUB_TOKEN`.
  Existing APK build attestation is verified against the publishing workflow
  and exact producer SHA and retained when available. First-draft publication
  or failed producer APK retrieval can have no such proof: the recorder states
  this explicitly and never mints replacement build provenance under its own
  OIDC identity. Run/commit-step, package, version and Play APK checksum evidence
  remain separate from producer build provenance.

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

This scaffold has no application CI/build and no npm dependency; its Gradle
project declares only the Android Gradle Plugin. Its applicable PR checks are `Build Pages artifact`, `Dependency Review`, and
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
