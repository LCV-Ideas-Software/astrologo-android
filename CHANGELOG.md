# Changelog

All material changes to Astrologo Android are recorded here.

## [Unreleased]

### Changed

- Update the official CodeQL Action to v4.38.0 and Zizmor Action to v0.6.4,
  retaining full commit pins and aligning the current third-party inventory.

- Adopted repository-local native Dependabot auto-merge, weekly Monday updates
  in Sao Paulo, seven-day third-party cooldown and minor/patch groups with
  standalone majors. Native checks and rules remain the admission boundary.
- Removed the obsolete advanced CodeQL workflow in favor of configured
  Default Setup, and retired merge-group consumers and central-controller
  instructions without adding an application CI or package manifest.
- Kept the native Pages artifact/deployment split and added PR-retarget event
  coverage to Pages and Dependency Review. Aligned Zizmor and Scorecard with
  the native fleet pattern; Scorecard retains SARIF without external publishing.
- Aligned the official Linear CLI with Action v0.17.2 while preserving the
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
