# Contributing

Astrologo Android is public, but its private planning and operational context
are not. Contributions must preserve that boundary.

## Tracking and privacy

- Link a GitHub Issue to Linear only when both are explicit, unequivocal
  counterparts.
- Never copy sensitive Linear content or private Project drafts into this
  repository, public Discussions, commits, pull requests, or Pages.
- Never create speculative Issues to satisfy a reconciliation count.
- Do not commit credentials, tokens, signing material, `local.properties`,
  service-account files, personal data, or production payloads. Non-secret
  identifiers required by official configuration may be versioned; private
  planning and credential values remain prohibited.

## Change control

- Every change to `main` uses a pull request and the effective Enterprise and
  repository rules. Squash is the only merge method; no merge queue is used.
- Human-authored pull requests require explicit admission unless the operator
  grants a scoped exception. The local official GitHub CLI workflow arms native
  auto-merge for same-repository Dependabot pull requests at the exact head,
  including standalone major updates, subject to native checks and rules.
  Minor/patch grouping is not a merge-eligibility restriction. Dependabot does
  not require manual Codex/Copilot review or human intervention.
- Prefer native GitHub features and official Actions/CLIs. Customizations need
  a specific prior operator decision. This repository is independent: no
  central controller or retired Actions dependency-lock mechanism.
- Before commit, push, or opening/updating a pull request, present the complete
  local change report for operator approval. GitHub configuration changes need
  separate explicit approval; preparation does not authorize those changes.
- No workflow bypasses rulesets.
- Set workflow-level permissions to `{}` and grant each job only the token
  capabilities it demonstrably needs.
- Pin external Actions to full commit SHAs directly in each workflow.
- Use signed commits and keep the branch focused on its linked work item.
- Preserve the working Linear-GitHub and Slack-GitHub integrations and update
  actual issue/project relationships without copying private content.

## Validation

Before opening or updating a pull request:

1. validate edited workflows with Zizmor and preserve their full-SHA pins;
2. confirm the applicable native PR checks use their exact required context
   names and cover retargeting to `main`;
3. run only checks applicable to the current repository state;
4. record exact SHA-based evidence in the pull request and tracking issue.

Do not create fake Gradle files or run Android build gates before a real
application scaffold exists. Do not add npm dependencies or custom validators
only to create a CI job for this documentation-only scaffold. Preserve the
inert Code Quality probe and the complete legal texts. Do not run `cargo` or
`rustc` locally, use Codespaces, or change commit-signing configuration.

After an approved merge, verify main/Pages/Linear and clean only this task's
branches after proving their work is preserved. Read [INBOUND.md](INBOUND.md)
for contributor-owned material; the original AGPL license is unchanged.
