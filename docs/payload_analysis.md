# Payload Analysis

### Goal:
Decode control signal patterns from PCAP payloads captured via PCAPdroid app.

### Key Observations:
- Payloads start with `cc5a01` consistently.
- Arming motor payload: `cc5a01820236b7`
- Throttle ranges vary in bytes 6–10.
