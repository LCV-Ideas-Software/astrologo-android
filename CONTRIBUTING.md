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
  service-account files, personal data, production payloads, or real internal
  infrastructure identifiers.

## Change control

- After the one-time empty-repository seed, every change to `main` uses a pull
  request and GitHub's native merge queue. Squash is the only merge method.
- Human-authored pull requests require explicit admission unless the operator
  grants a scoped exception. Canonical Dependabot pull requests may use the
  central controller only after the exact head satisfies the same rules.
- No workflow bypasses rulesets or performs a direct merge.
- Set workflow-level permissions to `{}` and grant each job only the token
  capabilities it demonstrably needs.
- Pin external Actions to full commit SHAs and regenerate
  `.github/workflows/actions.lock` after dependency changes.
- Use signed commits and keep the branch focused on its linked work item.

## Validation

Before opening or updating a pull request:

1. run `gh actions-lock --no-fix` and require `valid: true`; use an explicit
   dependency-update change to refresh the lockfile without replacing the
   repository's required full-SHA workflow pins;
2. confirm that all merge-queue checks also run on `merge_group` under the
   exact required context names;
3. run only checks applicable to the current repository state;
4. record exact SHA-based evidence in the pull request and tracking issue.

Do not create fake Gradle files or run Android build gates before a real
application scaffold exists.
