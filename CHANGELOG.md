# Changelog

All material changes to Astrologo Android are recorded here.

## [Unreleased]

### Added

- Bring the Google Play publication pipeline to the fleet baseline, PANDROI-40,
  by copying it verbatim from calculadora-android, where it was exercised end to
  end on a real publication on 20/09/2026. Both workflow files are byte-identical
  to that repository's, because an implementation already reviewed, merged and
  proven in production is worth more than a re-derivation of it.

  `publish-play.yml` gains four things it lacked. Release notes now travel with
  the track update, as `releases[].releaseNotes[]` of `LocalizedText {language,
  text}` with a BCP-47 tag, read from `play/release-notes/pt-BR.txt` and checked
  against the 500-character-per-language ceiling before the build — without them a
  publication reaches the store with an empty "what's new". A `release_status`
  input carries `completed` or `draft`, because an app that has never been
  published only accepts `draft` on the public track: *"Only releases with status
  draft may be created on draft app"*, and a person finishes that first
  publication in the Console. Every call to the Play API goes through a helper
  that prints which call failed and what Google Play answered, since
  `--fail-with-body` writes to standard output and the calls redirect it —
  without the helper an HTTP 400 reaches the log as `curl: (22)` and nothing
  more, and turning on debug logging does not recover it. And a production
  publication records a GitHub Release with the universal APK Play signed,
  `SHA256SUMS` and a provenance attestation.

  `record-play-release.yml` is new: it records that Release for a version already
  on the store, given its `versionCode`, without rebuilding or re-uploading.
  It exists because a first publication cannot be automated end to end — by the
  time the Console finishes it, the publishing workflow has exited, and
  re-dispatching it would re-upload a `versionCode` Play refuses.

  This repository has no application yet, so no release-notes file is created and
  the publishing workflow stops before building until one is written. The
  `versionCode` 1 was already consumed by the internal publication of 17/09/2026,
  so the first real version must carry 2 or higher.

### Changed

- Complete the third-party inventory for the Actions the workflows actually use.
  `actions/attest` and `actions/download-artifact` arrive with this change;
  `actions/setup-java`, `gradle/actions` and `google-github-actions/auth` were
  already used by `publish-play.yml` and were missing from the table. `gradle/actions`
  is recorded as its own `LICENSE` states — primarily MIT, with a vendored
  proprietary component — rather than flattened to MIT, which is why GitHub
  classifies that repository as `NOASSERTION`.

### Changed

- Update the official CodeQL Action to v4.38.0 and Zizmor Action to v0.6.4,
  retaining full commit pins and aligning the current third-party inventory.

- Adopted repository-local native Dependabot auto-merge and daily updates at
  05:00 in fixed UTC-03:00, including weekends, seven-day third-party cooldown
  and minor/patch groups with
  standalone majors. Native checks and rules remain the admission boundary.
- Group security updates separately from version updates.
- Removed the obsolete advanced CodeQL workflow in favor of configured
  Default Setup, and retired merge-group consumers and central-controller
  instructions without adding an application CI or package manifest.
- Kept the native Pages artifact/deployment split and added PR-retarget event
  coverage to Pages and Dependency Review. Aligned Zizmor and Scorecard with
  the native fleet pattern; Scorecard retains SARIF without external publishing.
- Aligned the official Linear CLI with Action v0.18.0 while preserving the
  main commit-history pipeline, dedicated environment and native pending queue.
- Added the repository-local inbound rights policy and updated governance and
  third-party inventory descriptions without changing original legal texts,
  the public site, or the inert Code Quality probe.

### Added

- Established the public repository baseline without claiming a functional
  Android application.
- Added independent governance, contribution, security, licensing, and
  third-party documentation.
- Added the standard CodeQL, Dependency Review, Zizmor, OpenSSF Scorecard,
  Dependabot, Pages, and official Linear Release workflows.
- Added a deliberately inert JavaScript probe for GitHub Code Quality.
- Added repository ownership and organization sponsorship metadata.

### Fixed

- Removed the obsolete Actions dependency lock and its workflow onboarding
  markers to restore workflow startup after Dependabot updates. Direct SHA
  pins, workflow behavior and repository security settings are unchanged.
