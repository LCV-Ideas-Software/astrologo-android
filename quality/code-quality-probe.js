/**
 * Analysis-only JavaScript marker for GitHub Code Quality.
 *
 * This module is deliberately not imported by Pages, an Android application,
 * or any production runtime. It keeps one supported language observable until
 * real application source exists; it is not evidence of Kotlin coverage.
 */
export const CODE_QUALITY_PROBE = Object.freeze({
  repository: "LCV-Ideas-Software/astrologo-android",
  purpose: "GitHub Code Quality language detection",
});
