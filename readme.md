**# 🛸 FPV Drone Signal Reverse Engineering Lab**

An advanced research project aimed at decoding and controlling undocumented WiFi-based FPV drones using raw UDP signals — without vendor SDKs or APIs.

Built from scratch by analyzing packet captures, isolating payloads, and testing direct socket injection to replicate flight control behavior.

---

[![MIT License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Python](https://img.shields.io/badge/python-3.9%2B-yellow.svg)](https://www.python.org/)
[![Wireshark](https://img.shields.io/badge/tool-Wireshark-007ACC.svg)](https://www.wireshark.org/)
[![Status](https://img.shields.io/badge/status-in%20active%20development-orange)]()

---

**## 📡 Project Overview**
This repository contains everything needed to reverse-engineer and control a toy-grade FPV drone via UDP packets, using nothing but WiFi, PCAP captures, and Python.

This drone had no official documentation or development kit — all commands were deciphered manually from raw network captures.

---

**## 📁 Project Structure**

```bash
.
├── scripts/                  # Python tools to inject/loop UDP packets
│   ├── drone_blast_loop.py
│   └── single_payload_test.py
├── captures/                # PCAP and extracted traffic samples
│   └── RCFPVPro_takeoff.pcap
├── docs/
│   ├── origin_story.md      # The story behind this project
│   ├── payload_analysis.md  # Manual payload decoding notes
│   └── research_logbook.md  # Experimental logs (coming soon)
├── README.md
├── LICENSE
└── .gitignore
```

**🧠 Techniques Applied**
Payload Pattern Differentiation using Wireshark

Socket-Level Packet Reconstruction via Python’s socket module

Live Payload Testing to identify effects (takeoff, throttle, etc.)

Manual Reverse Engineering of undocumented drone protocols

**🚧 Current Capabilities**
Feature	Status
Takeoff command injection	✅ Working
Motor activation payload	✅ Identified
Throttle pattern testing	🧪 In progress
WASD flight control system	🔧 Planned
Full protocol map	🔬 Building

**🧬 Future Plans**
Build a GUI to control the drone like a flight simulator

Add keyboard support (W, A, S, D, SPACE) using pynput

Expand payload mapping to include flips, pitch, yaw, etc.

Auto-capture payloads from live PCAPs and generate tests

**📜 Background**
This project was born from necessity. The full story is available in docs/origin_story.md.


```
**⚠️ Disclaimer**
This project is for educational and research purposes only. Do not attempt to control drones you don’t own or operate them outside legal bounds.

👤 Author
Developed by Harsh —
CEO @ SparkBee Technologies • Cybersecurity tinkerer • Drone hacker
```
www.hsbofficial.com

