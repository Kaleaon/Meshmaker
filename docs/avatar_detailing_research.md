# Avatar Detailing Research Notes

## Makeup and tattoo workflows (Second Life/OpenSim)
- **Layered texture approach**: Use base skin templates (UVs aligned to SL
  standards) and add makeup/tattoo overlays in separate texture layers so they
  can be toggled or swapped without reauthoring the full albedo.
- **Micro-detailing**: Bake micro-normal and cavity details (pores, wrinkles,
  freckles, fabric weave) into secondary maps to avoid flattening the base skin
  color.
- **Material tuning**: Calibrate specular/roughness so cosmetics (lipstick,
  eyeliner, metallic pigments) read differently than skin; avoid a uniform
  gloss across the entire face.
- **Decals and masking**: Use masks to isolate tattoos and decals to specific
  body regions; keep edge falloff soft to avoid hard cut lines in-world.

## Boosting avatar detail beyond basic meshes
- **Topology density in hero zones**: Increase geometry where silhouettes
  matter (face, hands, shoulders) and keep density lower in hidden/flat areas.
- **Corrective blends**: Add shapekeys for extreme poses (elbows, knees,
  shoulders) to reduce deformation artifacts.
- **Multi-channel texture sets**: Maintain separate 2K/4K albedo, normal,
  roughness, and AO maps so assets scale with viewer settings.
- **Accessory layering**: Treat eyes, teeth, lashes, nails, and brow cards as
  modular accessories to increase perceived detail without inflating base mesh.

## Ruth 2.0 reference
- **Project link**: https://github.com/RuthAndRoth/Ruth2
- **Why it matters**: The Ruth 2.0 open-source body is a common OpenSim
  baseline. Review its topology, UV layout, and materials as a benchmark for
  compatibility with SL/OpenSim pipelines.
- **Local download**: `source/ruth2/Ruth2-master.zip` (downloaded from the
  RuthAndRoth GitHub org for offline review).
- **Action**: Compare the Ruth2 UV layout and material channels against our
  Meshmaker base to align export presets.
